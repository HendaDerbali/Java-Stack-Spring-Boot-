package com.dojoOverflowAssignment.models;

	import java.util.Date;
	import java.util.List;

	import org.springframework.format.annotation.DateTimeFormat;

	import jakarta.persistence.Column;
	import jakarta.persistence.Entity;
	import jakarta.persistence.FetchType;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.JoinColumn;
	import jakarta.persistence.JoinTable;
	import jakarta.persistence.ManyToMany;
	import jakarta.persistence.PrePersist;
	import jakarta.persistence.PreUpdate;
	import jakarta.persistence.Table;
	import jakarta.validation.constraints.NotNull;
	import jakarta.validation.constraints.Size;

	@Entity
	@Table(name = "tags")
	public class Tag {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		@NotNull
		@Size(min = 1, max = 255)
		private String name;

		// -------- n:M ----------
    	@ManyToMany(fetch = FetchType.LAZY)
		@JoinTable(name = "tags_questions", 
			joinColumns = @JoinColumn(name = "tag_id"), 
			inverseJoinColumns = @JoinColumn(name = "question_id"))
		private List<Question> questions;

		// This will not allow the createdAt column to be updated after creation
		@Column(updatable = false)
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		private Date createdAt;
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		private Date updatedAt;

		@PrePersist
		protected void onCreate() {
			this.createdAt = new Date();
		}

		@PreUpdate
		protected void onUpdate() {
			this.updatedAt = new Date();
		}

		// Empty Constructor :
		public Tag() {

		}

		// Second Constructor :
		public Tag(String name) {
			this.name = name;
		}

		// Getters and Setters

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<Question> getQuestions() {
			return questions;
		}

		public void setQuestions(List<Question> questions) {
			this.questions = questions;
		}

		public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}

		public Date getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}

		
	}