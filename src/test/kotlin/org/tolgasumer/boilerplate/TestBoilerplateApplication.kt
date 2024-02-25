package org.tolgasumer.boilerplate

import org.springframework.boot.fromApplication
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.with

@TestConfiguration(proxyBeanMethods = false)
class TestboilerplateApplication

fun main(args: Array<String>) {
    fromApplication<boilerplateApplication>().with(TestboilerplateApplication::class).run(*args)
}
