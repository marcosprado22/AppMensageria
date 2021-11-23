package br.edu.up.kafkaschemaregistryvote

import br.edu.up.kafkaschemaregistryvote.entity.Pessoa
import br.edu.up.kafkaschemaregistryvote.producer.PessoaProducerImpl
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KafkaSchemaRegistryExampleApplication(
	val pessoaProducerImpl: PessoaProducerImpl
): ApplicationRunner{
	override fun run(args: ApplicationArguments?) {
		val pessoa = Pessoa("Jose", "jose.silva@rmail.com", "Alexandre Frota")
		Thread.sleep(5000)
		pessoaProducerImpl.persist("1", pessoa)
	}

}

fun main(args: Array<String>) {
	runApplication<KafkaSchemaRegistryExampleApplication>(*args)
}