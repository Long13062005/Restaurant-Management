import React, { useEffect } from 'react';
import * as THREE from 'three';

const ThreeJsScene = () => {
    useEffect(() => {
        // Create the scene
        const scene = new THREE.Scene();
        console.log('Scene created');

        // Set the background color
        scene.background = new THREE.Color(0x87CEEB); // Light blue color

        // Create a camera
        const camera = new THREE.PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000);
        camera.position.z = 5;
        console.log('Camera created');

        // Create a renderer
        const renderer = new THREE.WebGLRenderer();
        renderer.setSize(window.innerWidth, window.innerHeight);
        const container = document.getElementById('threejs-container');
        if (container) {
            container.appendChild(renderer.domElement);
            console.log('Renderer appended to container');
        } else {
            console.error('Container not found');
            return;
        }

        // Add a cube to the scene
        const geometry = new THREE.BoxGeometry();
        const material = new THREE.MeshBasicMaterial({ color: 0x00ff00 });
        const cube = new THREE.Mesh(geometry, material);
        scene.add(cube);
        console.log('Cube added to scene');

        // Animation loop
        const animate = () => {
            requestAnimationFrame(animate);

            // Rotate the cube
            cube.rotation.x += 0.01;
            cube.rotation.y += 0.01;

            // Render the scene
            renderer.render(scene, camera);
        };

        animate();

        // Resize the renderer on window resize
        const handleResize = () => {
            const width = window.innerWidth;
            const height = window.innerHeight;
            renderer.setSize(width, height);
            camera.aspect = width / height;
            camera.updateProjectionMatrix();
        };

        window.addEventListener('resize', handleResize);

        // Cleanup on unmount
        return () => {
            window.removeEventListener('resize', handleResize);
            if (container) {
                container.removeChild(renderer.domElement);
                console.log('Renderer removed from container');
            }
        };
    }, []);

    return <div id="threejs-container" style={{ width: '100%', height: '100vh' }} />;
};

export default ThreeJsScene;