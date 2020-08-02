package com.demo.design.pattern.build;

/**
 * 使用建造者模式可以在参数不确定的情况下构建实体
 */
public class Main {
    public static void main(String[] args) {
        TerrainBuilder tb = new ComplexTerrainBuilder();
        Terrain terrain = tb
                .buildFort("my fort")
                .buildWall("my wall")
                .buildMine("my mine")
                .build();
        System.out.println(terrain);
    }
}
