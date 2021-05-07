package io.reflectoring;

import java.util.Objects;

public class Uuid {
    public String uuid;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Uuid)) return false;
        Uuid uuid1 = (Uuid) o;
        return uuid.equals(uuid1.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }
}
