package pt.ulusofona.cd.product.repository;

import pt.ulusofona.cd.product.model.Identifiable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

public abstract class InMemoryRepository<T extends Identifiable> {

    private final Map<UUID, T> store = new ConcurrentHashMap<>();

    public T save(T entity) {
        if (entity.getId() == null) {
            entity.setId(UUID.randomUUID());
        }
        store.put(entity.getId(), entity);
        return entity;
    }

    public Optional<T> findById(UUID id) {
        return Optional.ofNullable(store.get(id));
    }

    public List<T> findAll() {
        return new ArrayList<>(store.values());
    }

    public boolean existsById(UUID id) {
        return store.containsKey(id);
    }

    public boolean deleteById(UUID id) {
        return store.remove(id) != null;
    }

    public long count() {
        return store.size();
    }

    protected Stream<T> stream() {
        return store.values().stream();
    }
}