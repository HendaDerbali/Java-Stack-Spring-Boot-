package com.dojoOverflowAssignment.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dojoOverflowAssignment.models.Tag;
import com.dojoOverflowAssignment.repositories.TagRepository;

@Service
public class TagService {

	// adding the Tag repository as a dependency
	private final TagRepository tagRepository;

	public TagService(TagRepository tagRepository) {
		this.tagRepository = tagRepository;
	}

	// returns all the Tags
	public List<Tag> allTags() {
		return tagRepository.findAll();
	}

	// creates a Tag
	public Tag createTag(Tag b) {
		return tagRepository.save(b);
	}

	// retrieves a Tag
	public Tag findTag(Long id) {
		Optional<Tag> optionalTag = tagRepository.findById(id);
		if (optionalTag.isPresent()) { // isPresent() : method to check if our object exists.
			return optionalTag.get();
		} else {
			return null;
		}
	}

	// update a Tag
	public Tag updateTag(Tag b) {
		return tagRepository.save(b);
	}

	public void deleteTag(Long id) {
		tagRepository.deleteById(id);
	}

	// find by containing
	public List<Tag> TagsContaining(String search) {
		return tagRepository.findByNameContaining(search);
	}

// Find By name 
	public Tag findByName(String search) {
		return tagRepository.findByNameIs(search);
	}

}