package com.demo.design.pattern.build;

public class ComplexTerrainBuilder implements TerrainBuilder {

    private Terrain terrain = new Terrain();

    @Override
    public TerrainBuilder buildWall(String wall) {
        terrain.setWall(wall);
        return this;
    }

    @Override
    public TerrainBuilder buildFort(String fort) {
        terrain.setFort(fort);
        return this;
    }

    @Override
    public TerrainBuilder buildMine(String mine) {
        terrain.setMine(mine);
        return this;
    }

    @Override
    public Terrain build() {
        return terrain;
    }
}
