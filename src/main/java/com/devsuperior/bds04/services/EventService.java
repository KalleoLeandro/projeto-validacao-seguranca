/**
 * 
 */
package com.devsuperior.bds04.services;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.bds04.dto.EventDTO;
import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.entities.Event;
import com.devsuperior.bds04.repositories.CityRepository;
import com.devsuperior.bds04.repositories.EventRepository;
import com.devsuperior.bds04.services.exceptions.ResourceNotFoundException;



/**
 * @author Kalleo
 *
 */

@Service
public class EventService {
		
	@Autowired
	private EventRepository eventRepository;
		
	@Autowired
	private CityRepository cityRepository;
	
	@Transactional(readOnly = true)	
	public Page<EventDTO> findAllPaged(Pageable pageable){		
		Page<Event> list = eventRepository.findAll(pageable);
		return list.map(x -> new EventDTO(x));
	}
	
	@Transactional
	public EventDTO insert (EventDTO dto) {
		Event entity = new Event();
		entity.setName(dto.getName());
		Optional<City> obj = cityRepository.findById(dto.getCityId());
		City city = obj.orElseThrow(()-> new ResourceNotFoundException("Entity not found"));
		entity.setCity(city);
		entity.setDate(dto.getDate());
		entity.setUrl(dto.getUrl());
		entity = eventRepository.save(entity);
		return new EventDTO(entity);
	}
}
