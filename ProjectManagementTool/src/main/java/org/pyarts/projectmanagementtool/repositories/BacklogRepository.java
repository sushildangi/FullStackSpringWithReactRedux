package org.pyarts.projectmanagementtool.repositories;

import org.pyarts.projectmanagementtool.domain.Backlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BacklogRepository extends JpaRepository<Backlog, Long> {
}
