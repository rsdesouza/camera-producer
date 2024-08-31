package mpes.cesar.school.camera_producer.controller;

import mpes.cesar.school.camera_producer.payload.MessagePayload;
import mpes.cesar.school.camera_producer.service.MqttPublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/camera")
public class CameraController {

    private final MqttPublisherService mqttPublisherService;

    @Autowired
    public CameraController(MqttPublisherService mqttPublisherService) {
        this.mqttPublisherService = mqttPublisherService;
    }

    @PostMapping("/publish")
    public String publishMessage(@RequestParam String topic, @RequestBody MessagePayload payload) {
        mqttPublisherService.publish(topic, payload.getContent());
        return "Message published to topic: " + topic;
    }
}
