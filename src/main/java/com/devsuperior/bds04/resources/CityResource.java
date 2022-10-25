/**
 * 
 */
package com.devsuperior.bds04.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devsuperior.bds04.dto.CityDTO;
import com.devsuperior.bds04.services.CityService;


/**
 * @author Kalleo
 *
 */

@RestController
@RequestMapping(value= "/cities")
public class CityResource {
	
	@Autowired
	private CityService cityService;
	
	@GetMapping
	public ResponseEntity<Page<CityDTO>> findAll(Pageable pageable){
				
		Page<CityDTO> list = cityService.findAllPaged(pageable);
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<CityDTO> insert(@Valid @RequestBody CityDTO dto){
		dto = cityService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
		
	}
}
