public class SpinningDonut {
    public static void main(String[] args) {
        double A = 0, B = 0;
        int width = 40, height = 20; // Size of the ASCII grid
        double theta_spacing = 0.07, phi_spacing = 0.02; // Angular resolution
        double K1 = 25; // Distance constant
        double K2 = 10; // Controls donut size

        char[][] output = new char[height][width];
        double[][] zBuffer = new double[height][width];

        while (true) {
            // Initialize buffer for new frame
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    output[i][j] = ' ';
                    zBuffer[i][j] = 0;
                }
            }

            // Loop over torus surface angles
            for (double theta = 0; theta < 2 * Math.PI; theta += theta_spacing) {
                for (double phi = 0; phi < 2 * Math.PI; phi += phi_spacing) {
                    double cosA = Math.cos(A), sinA = Math.sin(A);
                    double cosB = Math.cos(B), sinB = Math.sin(B);
                    double cosTheta = Math.cos(theta), sinTheta = Math.sin(theta);
                    double cosPhi = Math.cos(phi), sinPhi = Math.sin(phi);

                    // 3D coordinates of the point on the torus
                    double circleX = K2 + Math.cos(theta);
                    double circleY = Math.sin(theta);

                    // Apply rotation
                    double x = circleX * (cosB * cosPhi + sinA * sinB * sinPhi) - circleY * cosA * sinB;
                    double y = circleX * (sinB * cosPhi - sinA * cosB * sinPhi) + circleY * cosA * cosB;
                    double z = K1 + cosA * circleX * sinPhi + circleY * sinA;
                    double ooz = 1 / z;

                    // Project to 2D
                    int xp = (int) ((double) width / 2 + 30 * ooz * x);
                    int yp = (int) ((double) height / 2 - 15 * ooz * y);

                    // Calculate brightness
                    double L = cosPhi * cosTheta * sinB - cosA * cosTheta * sinPhi - sinA * sinTheta + cosB * (cosA * sinTheta - cosTheta * sinA * sinPhi);
                    char brightness = L > 0 ? ".,-~:;=!*#$@".charAt((int) (L * 8)) : ' ';

                    if (xp >= 0 && xp < width && yp >= 0 && yp < height && ooz > zBuffer[yp][xp]) {
                        zBuffer[yp][xp] = ooz;
                        output[yp][xp] = brightness;
                    }
                }
            }

            // Print frame
            System.out.print("\u001b[H"); // ANSI escape to clear the console
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    System.out.print(output[i][j]);
                }
                System.out.println();
            }

            A += 0.04;
            B += 0.02;

            try {
                Thread.sleep(16); // Control frame rate
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
