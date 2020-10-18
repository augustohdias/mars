package dev.augustohdias.mars.controllers;

import dev.augustohdias.mars.models.entities.Probe;
import dev.augustohdias.mars.models.request.parameters.CreateProbe;
import dev.augustohdias.mars.models.request.parameters.MoveProbe;
import dev.augustohdias.mars.services.ProbeService;
import java.util.List;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/mars/v1/probes")
public class ProbeController {

  private final ProbeService service;

  @PostMapping
  public Probe createProbe(@RequestBody @Valid CreateProbe parameters) {
    return service.createProbe(parameters);
  }

  @GetMapping
  public List<Probe> listProbes() {
    return service.listProbes();
  }

  @GetMapping("{id}")
  public Probe getProbeById(@PathVariable Integer id) {
    return service.getProbeById(id);
  }

  @PatchMapping("{id}")
  public Probe moveProbe(@PathVariable Integer id, @RequestBody @Valid MoveProbe parameters) {
    return service.moveProbe(id, parameters);
  }
}
