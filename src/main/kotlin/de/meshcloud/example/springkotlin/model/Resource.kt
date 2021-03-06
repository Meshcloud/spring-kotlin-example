package de.meshcloud.example.springkotlin.model

import java.time.Instant
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import javax.persistence.*

@Entity
data class Resource(

    @Id
    @GeneratedValue
    val id: Long? = null,

    var name: String,

    var description: String? = null,

    var type: ResourceType,

    var startDate: Instant,

    var endDate: Instant?,

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    var project: Project

) {
  fun durationInHours(): Long {
    return startDate.until(endDate, ChronoUnit.HOURS)
  }
}
