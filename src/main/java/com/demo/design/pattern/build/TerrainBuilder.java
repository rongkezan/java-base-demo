package com.demo.design.pattern.build;

public interface TerrainBuilder {

    TerrainBuilder buildWall(String wall);

    TerrainBuilder buildFort(String fort);

    TerrainBuilder buildMine(String mine);

    Terrain build();
}
