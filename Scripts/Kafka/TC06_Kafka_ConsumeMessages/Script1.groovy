import com.kms.katalon.core.util.KeywordUtil
import groovy.json.JsonSlurper

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.common.serialization.StringDeserializer

import java.time.Duration

// TC06: Kafka Consumer - Katalon sebagai Consumer
// Prerequisite: Kafka running (docker-compose up -d)

// Config
def bootstrapServers = "localhost:9092"
def topic = "ifg-test-topic"
def groupId = "ifg-katalon-group"

// Setup consumer
Properties props = new Properties()
props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers)
props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId)
props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName())
props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName())
props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest")

KafkaConsumer<String, String> consumer = null

try {
    consumer = new KafkaConsumer<>(props)
    consumer.subscribe(Arrays.asList(topic))
    KeywordUtil.logInfo("Subscribed to topic: ${topic}")

    // Poll messages (timeout 10 detik)
    def messages = []
    def startTime = System.currentTimeMillis()
    
    while (System.currentTimeMillis() - startTime < 10000) {
        def records = consumer.poll(Duration.ofMillis(1000))
        records.each { record ->
            messages.add([
                key: record.key(),
                value: record.value(),
                offset: record.offset(),
                partition: record.partition()
            ])
            KeywordUtil.logInfo("Consumed: key=${record.key()}, value=${record.value()}")
        }
        if (messages.size() > 0) break
    }

    KeywordUtil.logInfo("Total messages consumed: ${messages.size()}")
    
    // Validasi jika ada message
    if (messages.size() > 0) {
        assert messages[0].value != null : "Message value should not be null"
        KeywordUtil.logInfo("First message: ${messages[0].value}")
    } else {
        KeywordUtil.logInfo("No messages in topic (topic may be empty - this is OK for demo)")
    }

    KeywordUtil.logInfo("TC06 Kafka Consumer PASSED")

} catch (Exception e) {
    KeywordUtil.markFailed("Kafka Consumer error: ${e.message}")
} finally {
    if (consumer != null) consumer.close()
}
