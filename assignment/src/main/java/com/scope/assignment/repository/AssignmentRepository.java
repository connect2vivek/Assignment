package com.scope.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scope.assignment.model.AssignmentModel;

@Repository
public interface AssignmentRepository extends JpaRepository<AssignmentModel, Integer> {
	public AssignmentModel findByEmail(String email);
	public AssignmentModel findById(int id);
}
