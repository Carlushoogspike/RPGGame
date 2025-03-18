package net.bytes.projects.rpg.microservice.player;

import io.micronaut.http.annotation.Controller;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@ExecuteOn(TaskExecutors.IO)
public class PlayerController {



}
