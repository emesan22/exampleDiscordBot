package io.github.emesan22.exampleDiscordBot

import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.entities.Activity
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import net.dv8tion.jda.api.requests.GatewayIntent

class DiscordBot : ListenerAdapter() {
    private lateinit var jda: JDA

    fun main(token: String) {
        jda = JDABuilder.createLight(token, GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT)
            .setRawEventsEnabled(true)
            .addEventListeners(this)
            .setActivity(Activity.streaming("This is test Bot!", "https://zenn.dev/emesan/books/kotlin-jda"))
            .build()
    }

    override fun onMessageReceived(event: MessageReceivedEvent) {
        if (!event.author.isBot && event.guild.id == "885858359813742593") {
            if (event.message.contentDisplay.startsWith("こん")) {
                event.channel.sendMessage("こんにちは~").queue()
            }
            if (event.message.contentDisplay.startsWith("おは")) {
                event.channel.sendMessage("おはよう~").queue()
            }
        }
    }
}

fun main() {
    val token = "ここにトークン"
    DiscordBot().main(token)
}