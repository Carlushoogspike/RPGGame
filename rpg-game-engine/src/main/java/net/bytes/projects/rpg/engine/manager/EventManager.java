package net.bytes.projects.rpg.engine.manager;

import java.lang.reflect.Method;
import java.util.*;
import java.util.function.Consumer;

public class EventManager {
    private static final Map<Class<?>, List<Consumer<Object>>> eventListeners = new HashMap<>();

    /**
     * Registra um listener e mapeia todos os métodos anotados com @EventHandler.
     */
    public static void registerListener(Listener listener) {
        for (Method method : listener.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(EventRegistry.class) &&
                method.getParameterCount() == 1) {

                Class<?> eventType = method.getParameterTypes()[0];
                method.setAccessible(true);

                eventListeners.computeIfAbsent(eventType, k -> new ArrayList<>())
                        .add(event -> {
                            try {
                                method.invoke(listener, event);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        });
            }
        }
    }

    /**
     * Dispara um evento e chama todos os ouvintes correspondentes.
     */
    public static void callEvent(Object event) {
        List<Consumer<Object>> listeners = eventListeners.get(event.getClass());
        if (listeners != null) {
            for (Consumer<Object> listener : listeners) {
                listener.accept(event);
            }
        }
    }
}
