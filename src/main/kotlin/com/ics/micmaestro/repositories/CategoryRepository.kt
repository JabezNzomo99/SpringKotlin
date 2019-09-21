package com.ics.micmaestro.repositories

import com.ics.micmaestro.models.Category
import org.springframework.data.jpa.repository.JpaRepository

interface CategoryRepository:JpaRepository<Category,Long>