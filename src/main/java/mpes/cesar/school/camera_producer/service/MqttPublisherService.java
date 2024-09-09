package mpes.cesar.school.camera_producer.service;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MqttPublisherService {

    private final MqttClient mqttClient;

    @Autowired
    public MqttPublisherService(MqttClient mqttClient) {
        this.mqttClient = mqttClient;
    }

    public void publish(String topic, String payload) {
        try {
            MqttMessage message = new MqttMessage(payload.getBytes());
            message.setQos(2); // Qualidade de Serviço (QoS) pode ser 0, 1, ou 2
            mqttClient.publish(topic, message);
            System.out.println("Message published to topic " + topic + ": " + payload);
        } catch (MqttException e) {
                e.printStackTrace();
        }
    }
}
