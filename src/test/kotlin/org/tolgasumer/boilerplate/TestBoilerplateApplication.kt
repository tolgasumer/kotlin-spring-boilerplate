package org.tolgasumer.boilerplate

import org.springframework.boot.fromApplication
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.with

@TestConfiguration(proxyBeanMethods = false)
class TestBoilerplateApplication

fun main(args: Array<String>) {
    fromApplication<BoilerplateApplication>().with(TestBoilerplateApplication::class).run(*args)
}
