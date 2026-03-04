import java.util.Random;
import java.util.Scanner;

public class Main {

    public static int rolarDado() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    public static String[] desenharDado(int valor) {
        switch (valor) {
            case 1:
                return new String[]{
                        "┌─────┐",
                        "│     │",
                        "│  ●  │",
                        "│     │",
                        "└─────┘"
                };
            case 2:
                return new String[]{
                        "┌─────┐",
                        "│ ●   │",
                        "│     │",
                        "│   ● │",
                        "└─────┘"
                };
            case 3:
                return new String[]{
                        "┌─────┐",
                        "│ ●   │",
                        "│  ●  │",
                        "│   ● │",
                        "└─────┘"
                };
            case 4:
                return new String[]{
                        "┌─────┐",
                        "│ ● ● │",
                        "│     │",
                        "│ ● ● │",
                        "└─────┘"
                };
            case 5:
                return new String[]{
                        "┌─────┐",
                        "│ ● ● │",
                        "│  ●  │",
                        "│ ● ● │",
                        "└─────┘"
                };
            case 6:
                return new String[]{
                        "┌─────┐",
                        "│ ● ● │",
                        "│ ● ● │",
                        "│ ● ● │",
                        "└─────┘"
                };
        }
        return null;
    }

    public static boolean verificarTrinca(int d1, int d2, int d3) {
        return (d1 == d2 && d2 == d3);
    }

    public static void mostrarDados(int d1, int d2, int d3) {
        String[] dado1 = desenharDado(d1);
        String[] dado2 = desenharDado(d2);
        String[] dado3 = desenharDado(d3);

        for (int i = 0; i < 5; i++) {
            System.out.println(dado1[i] + "  " + dado2[i] + "  " + dado3[i]);
        }

        System.out.println("Soma: " + (d1 + d2 + d3));
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("🎲 JOGO DOS 3 DADOS 🎲");
        System.out.println("Pressione ENTER para rolar...");
        scanner.nextLine();

        // Jogador
        int j1 = rolarDado();
        int j2 = rolarDado();
        int j3 = rolarDado();

        System.out.println("\n🎮 Você rolou:");
        mostrarDados(j1, j2, j3);

        // Computador
        System.out.println("\n🤖 Computador está rolando...");
        int c1 = rolarDado();
        int c2 = rolarDado();
        int c3 = rolarDado();

        System.out.println("\n🤖 Computador rolou:");
        mostrarDados(c1, c2, c3);

        int somaJogador = j1 + j2 + j3;
        int somaComputador = c1 + c2 + c3;

        System.out.println("\n🏆 RESULTADO FINAL:");

        if (verificarTrinca(j1, j2, j3) && !verificarTrinca(c1, c2, c3)) {
            System.out.println("🔥 Você venceu com TRINCA!");
        } else if (!verificarTrinca(j1, j2, j3) && verificarTrinca(c1, c2, c3)) {
            System.out.println("🔥 Computador venceu com TRINCA!");
        } else {
            if (somaJogador > somaComputador) {
                System.out.println("Você venceu pela soma!");
            } else if (somaComputador > somaJogador) {
                System.out.println("Computador venceu pela soma!");
            } else {
                System.out.println("Empate!");
            }
        }

        scanner.close();
    }
}