package org.safa.sparkr

import org.springframework.boot.fromApplication
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.with

@TestConfiguration(proxyBeanMethods = false)
class TestSparkrApplication

fun main(args: Array<String>) {
    fromApplication<SparkrApplication>().with(TestSparkrApplication::class).run(*args)
}
