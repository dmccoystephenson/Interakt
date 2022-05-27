/*
  Copyright (c) 2022 Daniel McCoy Stephenson
  Apache License 2.0
 */
package dansapps.interakt.factories;

import dansapps.interakt.data.PersistentData;
import dansapps.interakt.objects.Square;
import dansapps.interakt.utils.Logger;

import java.util.Map;
import java.util.UUID;

/**
 * @author Daniel McCoy Stephenson
 * @since January 15th, 2022
 */
public class SquareFactory {
    private Logger logger;

    public SquareFactory(Logger logger) {
        this.logger = logger;
    }

    public UUID createSquare(int x, int y, UUID gridUUID) {
        Square square = new Square(x, y, gridUUID, logger);
        PersistentData.getInstance().addSquare(square);
        return square.getUUID();
    }

    public void createSquare(Map<String, String> data) {
        Square square = new Square(data, logger);
        PersistentData.getInstance().addSquare(square);
    }
}