package dataStructures.Hashing;

import java.util.ArrayList;
import java.util.LinkedList;

public class CustomHashMap2<K, V> {

    ArrayList<LinkedList<Entity>> list;

    private int size = 0;
    private float loadFactor = 0.5f;

    public CustomHashMap2() {
        list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new LinkedList<>());
        }
    }

    public void put(K key, V value) {
        int hash = Math.abs(key.hashCode() % list.size());

        LinkedList<Entity> entities = list.get(hash);

        for (Entity entity: entities) {
            if (entity.key.equals(key)) {
                entity.value = value;
                return;
            }
        }

        if ((float) size / list.size() > loadFactor) {
            reHash();
        }

        entities.add(new Entity(key, value));
        size++;
    }

    public V get(K key) {
        int hash = Math.abs(key.hashCode() % list.size());
        LinkedList<Entity> entities = list.get(hash);

        for (Entity entity: entities) {
            if (entity.key.equals(key)) {
                return entity.value;
            }
        }
        return null;
    }

    public V remove(K key) {
        int hash = Math.abs(key.hashCode() % list.size());
        LinkedList<Entity> entities = list.get(hash);

        Entity target = null;

        for (Entity entity: entities) {
            if (entity.key.equals(key)) {
                target = entity;
                break;
            }
        }

        entities.remove(target);
        size --;

        return target.value;
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    private void reHash() {
        System.out.println("rehashing the map");

        ArrayList<LinkedList<Entity>> old = list;
        list = new ArrayList<>();

        size = 0;

        for (int i = 0; i < old.size() * 2; i++) {
            list.add(new LinkedList<>());
        }

        for (LinkedList<Entity> entries: old) {
            for (Entity entry: entries) {
                put(entry.key, entry.value);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{");

        for (LinkedList<Entity> entities: list) {
            for (Entity entity: entities) {
                builder.append(" ");
                builder.append(entity.key);
                builder.append(": ");
                builder.append(entity.value);
                builder.append(";");
            }
        }

        builder.append("}");

        return builder.toString();
    }

    private class Entity{
        K key;
        V value;

        public Entity(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
