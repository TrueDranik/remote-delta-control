package bstu.graduate.modbus.command;

import bstu.graduate.modbus.common.enums.CallbackEnum;
import bstu.graduate.modbus.utils.GenerateInlineKeyboardMarkup;
import bstu.graduate.modbus.utils.MessageBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;

@Component
@RequiredArgsConstructor
public class CommandStart implements BaseCommand {
    @Override
    public BotCommand getBotCommand() {
        return BotCommand.builder()
                .command("start")
                .description("начать/восстановить работу с ботом")
                .build();
    }

    @Override
    public BotApiMethod<?> getAction(Long chatId) {
        int countButtons = 2;
        String text = "Меню главного управления";

        String[] textButtons = {"Управление реле", "Управление ПЧ 'Дельта'"};
        CallbackEnum[] callbacks = {CallbackEnum.RELAY_CONTROL_MENU, CallbackEnum.DELTA_FC_CONTROL_MENU};

        return MessageBuilder.sendMessage(chatId, text, GenerateInlineKeyboardMarkup.withoutRow(countButtons, textButtons, callbacks));
    }
}