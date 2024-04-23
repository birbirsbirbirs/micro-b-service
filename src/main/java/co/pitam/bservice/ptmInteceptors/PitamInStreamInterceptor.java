package co.pitam.bservice.ptmInteceptors;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.config.GlobalChannelInterceptor;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptor;

@RequiredArgsConstructor
@Slf4j
@Configuration
@GlobalChannelInterceptor(patterns = {"*in-*"})
public class PitamInStreamInterceptor implements ChannelInterceptor {

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        return ChannelInterceptor.super.preSend(message, channel);
    }
}
