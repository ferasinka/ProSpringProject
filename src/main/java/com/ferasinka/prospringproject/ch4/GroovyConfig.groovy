package com.ferasinka.prospringproject.ch4

import org.springframework.beans.factory.groovy.GroovyBeanDefinitionReader
import org.springframework.context.support.GenericApplicationContext

def ctx = new GenericApplicationContext()
def reader = new GroovyBeanDefinitionReader(ctx)

reader.beans {
    contact(Contact, firstName: 'Andrey', lastName: 'Kuznetsov', age: 28)
}

ctx.refresh()

println ctx.getBean("contact")
