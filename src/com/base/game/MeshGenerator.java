package com.base.game;

import java.util.ArrayList;
import java.util.List;

import com.base.engine.core.Vector3f;
import com.base.engine.rendering.Mesh;
import com.base.engine.rendering.Vertex;

public class MeshGenerator {
    public static Mesh Generate(){
        List<Vertex> vertices=new ArrayList<Vertex>();
        List<Integer> triangles=new ArrayList<Integer>();

        vertices.add(new Vertex(new Vector3f(0, 0, 0)));//0
        vertices.add(new Vertex(new Vector3f(1, 0, 0)));//1
        vertices.add(new Vertex(new Vector3f(0, 1, 0)));//2
        vertices.add(new Vertex(new Vector3f(0, 0, 1)));//3
        vertices.add(new Vertex(new Vector3f(1, 1, 0)));//4
        vertices.add(new Vertex(new Vector3f(1, 0, 1)));//5
        vertices.add(new Vertex(new Vector3f(0, 1, 1)));//6
        vertices.add(new Vertex(new Vector3f(1, 1, 1)));//7
        
        triangles.add(3);
        triangles.add(1);
        triangles.add(0);
        triangles.add(5);
        triangles.add(0);
        triangles.add(1);

        Mesh mesh=new Mesh(vertices.toArray(new Vertex[0]), triangles.stream().mapToInt(i -> i).toArray());

        return mesh;
    }
}
