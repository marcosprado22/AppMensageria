package br.edu.up.kafkaschemaregistryvote.consumer

import br.edu.up.kafkaschemaregistryvote.entity.Pessoa
import br.edu.up.kafkaschemaregistryvote.entity.PessoaDTO
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.annotation.PartitionOffset
import org.springframework.kafka.annotation.TopicPartition
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class PessoaConsumerImpl {

    @KafkaListener(id = "pessoa-consumer",
        topicPartitions = [
            TopicPartition(
                topic = "Pessoa",
                partitions = ["0"],
                partitionOffsets = arrayOf(PartitionOffset(partition = "*", initialOffset = "0"))
            )
        ]
    )
    fun consume(@Payload pessoaDTO: PessoaDTO){
        val pessoa = Pessoa(pessoaDTO.getNome().toString(), pessoaDTO.getEmail().toString(), pessoaDTO.getVoto().toString())
        println("Pessoa recebida")
        println(pessoa.toString())
    }
}