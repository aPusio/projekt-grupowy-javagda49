package com.sda;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.hibernate.type.descriptor.sql.TinyIntTypeDescriptor;

@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class Point {
    private final Integer x;
    private final Integer y;

    public Point add(Point point) {
        return new Point(x + point.getX(), y + point.getY());
    }
}
