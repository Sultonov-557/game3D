package com.base.game;

import java.util.Random;

import com.base.engine.core.Vector3f;

public class VoxelMap {

    public Voxel[][][] voxelMap;

    public VoxelMap(Vector3f size) {
        voxelMap = new Voxel[(int) size.GetX()][(int) size.GetY()][(int) size.GetZ()];

        for (int x = 0; x < (int) size.GetX(); x++) {
            for (int y = 0; y < (int) size.GetY(); y++) {
                for (int z = 0; z < (int) size.GetZ(); z++) {
                    if (new Random().nextInt(100) > 50) {
                        voxelMap[x][y][z] = new Voxel(0);
                    } else {
                        voxelMap[x][y][z] = new Voxel(1);
                    }
                }
            }
        }

    }
}
