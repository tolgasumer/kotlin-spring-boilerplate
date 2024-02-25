package org.safa.sparkr

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SparkrApplication

fun main(args: Array<String>) {
    runApplication<SparkrApplication>(*args)
}
