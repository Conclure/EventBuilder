package me.conclure.eventbuilder;

import com.sun.istack.internal.NotNull;
import me.conclure.eventbuilder.implementation.EventBuilderFactory;
import me.conclure.eventbuilder.interfaces.EventBuilder;
import org.bukkit.event.Event;

public final class EventBuilders {

    private static final EventBuilderFactory FACTORY;

    static {
        try {
            FACTORY = EventBuilderFactory.class.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Creates a new {@link EventBuilder} from the {@param eventType}.
     *
     * @param eventType event class
     * @param <T> event type
     *
     * @return {@link EventBuilder}
     */
    @NotNull
    public static <T extends Event> EventBuilder<T> create(@NotNull Class<T> eventType) {
        return FACTORY.create(eventType);
    }

}
