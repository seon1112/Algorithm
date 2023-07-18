

import java.util.*;

class Player {
    private int level;
    private String nickname;

    public Player(int level, String nickname) {
        this.level = level;
        this.nickname = nickname;
    }

    public int getLevel() {
        return level;
    }

    public String getNickname() {
        return nickname;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt(); // 멤버수
        int m = sc.nextInt(); // 정원 수
        sc.nextLine();

        List<Player> players = new ArrayList<>();

        for (int i = 0; i < p; i++) {
            String s = sc.nextLine();
            String[] str = s.split(" ");
            int level = Integer.parseInt(str[0]);
            String nickname = str[1];
            players.add(new Player(level, nickname));
        }

        List<List<Player>> rooms = new ArrayList<>();
        for (Player player : players) {
            boolean matched = false;
            for (List<Player> room : rooms) {
                Player firstPlayer = room.get(0);
                if (Math.abs(firstPlayer.getLevel() - player.getLevel()) <= 10 && room.size() < m) {
                    room.add(player);
                    matched = true;
                    break;
                }
            }

            if (!matched) {
                List<Player> newRoom = new ArrayList<>();
                newRoom.add(player);
                rooms.add(newRoom);
            }
        }

        for (List<Player> room : rooms) {
            if (room.size() == m) {
                System.out.println("Started!");
            } else {
                System.out.println("Waiting!");
            }

            Collections.sort(room, Comparator.comparing(Player::getNickname));
            for (Player player : room) {
                System.out.println(player.getLevel() + " " + player.getNickname());
            }
        }
    }
}
