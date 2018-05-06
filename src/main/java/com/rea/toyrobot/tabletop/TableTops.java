package com.rea.toyrobot.tabletop;

import com.rea.toyrobot.common.util.Constants;
import com.rea.toyrobot.common.util.PropertyProvider;

/**
 * Factory class for creating {@link TableTop} instances.
 */
public class TableTops {

    private TableTops () {

    }

    public static TableTop newSquareTableTopDontAllowFall(int width, int height) {
        return new SquareTableTopNoFall(width, height);
    }

    public static TableTop newSquareTableTopAllowFall(int width, int height) {
        return new SquareTableTopAllowFall(width, height);
    }

    public static TableTop newSquareTableTopAllowFall(PropertyProvider properties) {
        String width = properties.getProperty(Constants.TABLETOP_WIDTH_PROPERTY);
        String height = properties.getProperty(Constants.TABLETOP_HEIGHT_PROPERTY);
        if(width != null && height != null) {
            return new SquareTableTopAllowFall(Integer.parseInt(width), Integer.parseInt(height));
        } else {
            throw new IllegalArgumentException("Can't create Tabletop for the given property provider.");
        }
    }

    public static TableTop newSquareTableTopDontAllowFall(PropertyProvider properties) {
        String width = properties.getProperty(Constants.TABLETOP_WIDTH_PROPERTY);
        String height = properties.getProperty(Constants.TABLETOP_WIDTH_PROPERTY);
        if(width != null && height != null) {
            return new SquareTableTopNoFall(Integer.parseInt(width), Integer.parseInt(height));
        } else {
            throw new IllegalArgumentException("Can't create Tabletop for the given property provider.");
        }
    }
}
