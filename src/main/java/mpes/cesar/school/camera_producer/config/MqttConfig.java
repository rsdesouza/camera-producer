package mpes.cesar.school.camera_producer.config;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqttConfig {

    private final String brokerUrl = "tcp://34.29.124.25:1883";
    private final String clientId = "emqx_NTA1Nz";

    @Bean
    public MqttClient mqttClient() {
        try {
            MqttClient client = new MqttClient(brokerUrl, clientId, new MemoryPersistence());
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            client.connect(connOpts);
            return client;
        } catch (Exception e) {
            throw new RuntimeException("Failed to connect to MQTT broker", e);
        }
    }
}
