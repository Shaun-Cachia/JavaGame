package JavaGame;
import java.util.*;
import java.io.*;

public class Game {
    static ArrayList<Character> characters = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();
    static boolean unlockedZebbugTown = false;
    static Character player;

    public static void main(String[] args) {
        int choice;
            System.out.println("Welcome to Divine Destiny: The Legend of Isaac");
            System.out.println("1. New Game");
            System.out.println("2. Load Game");
            System.out.println("3. Exit");
            System.out.println("Enter your choice:");

            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    createGame();
                    break;
                case 2:
                    loadGame();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }


        System.out.println("A young boy, Isaac, abandoned in a world oblivious to his origins,\n" +
                "was saved by an elderly couple who became the center of his growth.\n" +
                "Unfolding across the world are those who still recognize the power of his lineage.\n" +
                "Their actions set in motion events that will ultimately reshape the world.\n" +
                "As the boy matures, he aspires to emulate the strength of his guardian grandfather\n" +
                "and embark on a journey to discover his purpose and find God.");

        createCharacter();
        System.out.println("You are in Zebbug woods.");

        boolean travelZebbugWoods = false;

        int travels = 0;  // Variable to track the number of travels

        do {
            displayWorldActions();
            choice = sc.nextInt();
            switch (choice) {
                case 1: travelZebbugWoods = true;
                    if (travelZebbugWoods) {
                        System.out.println("You decide to travel through Zebbug Woods.");

                        // Introduce a random chance for an encounter
                        boolean encounter = shouldFight();
                        if (encounter) {
                            System.out.println("Oh no! You encountered an enemy!");
                            battleSystem(characters.get(0), createRandomEnemy());
                            // Additional logic for the fight can be added here
                        } else {
                            System.out.println("You travel peacefully through Zebbug Woods. Nothing happens.");
                            travels++;

                            // Check if Zebbug Town is unlocked after 15 travels
                            if (travels == 15) {
                                System.out.println("Congratulations! Zebbug Town is now unlocked.");
                                unlockedZebbugTown = true;
                                // Additional logic for unlocking Zebbug Town can be added here
                            }
                        }
                    } else {
                        System.out.println("You cannot travel at the moment.");
                    }
                    break;

                case 2:
                    System.out.println("You decide to camp.");
                    // Restore player's HP to max
                    player.restoreHPToMax();
                    System.out.println("Your HP is restored to max. Current HP: " + player.getHP() + "/" + player.getMaxHP());
                    break;

                case 3:
                    if (unlockedZebbugTown) {
                        System.out.println("You decide to go to Zebbug Town.");
                        // Additional logic for being in Zebbug Town can be added here
                        // You can break out of the loop or set a flag to indicate the player is in town
                    } else {
                        System.out.println("Zebbug Town is currently locked. Continue exploring Zebbug Woods.");
                    }
                    break;

                // Additional cases can be added for other actions
                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        } while (choice != 0);
    }

    private static void createGame() {
        try {
            File saveData = new File("savedata.txt");
            if (saveData.createNewFile()) {
                System.out.println("Save created: " + saveData.getName());
                // Add code to create characters or initialize game state
            } else {
                System.out.println("Save already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static void loadGame() {
        try {
            File saveData = new File("savedata.txt");
            Scanner fileScanner = new Scanner(saveData);
            while (fileScanner.hasNextLine()) {
                String data = fileScanner.nextLine();
                System.out.println(data);
                // Add code to parse character data and populate 'characters' list
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Save data not found.");
        }
    }

    private static void createCharacter() {
        // Ask the user for the character's name
        System.out.println("Enter the character's name (default is Isaac): ");
        String characterName = sc.next();
        if (characterName.isEmpty()) {
            characterName = "Isaac";
        }

        // Create the character
        Character newCharacter = new Character(characterName, 0, 1, 15, 5, 9, 4, 4, 7, "Healthy", "None", 15);
        characters.add(newCharacter);

        System.out.println("Character created:");
        System.out.println("Name: " + characterName);
        // Add additional character information as needed
    }

    private static boolean shouldFight() {
        // Define the chance of encountering a fight (e.g., 25%)
        int chance = 25;
        return random.nextInt(100) < chance;
    }

    private static Enemy createRandomEnemy() {
        // Define enemy types and their probabilities
        String[] enemyTypes = {"goo", "goblin", "mage goo"};
        int[] probabilities = {40, 40, 20}; // Out of 100

        // Randomly select an enemy type based on probabilities
        int index = selectRandomIndex(probabilities);

        // Based on the selected index, create and return the corresponding enemy
        switch (enemyTypes[index]) {
            case "goo":
                return new Enemy("Goo", 2, 0, 12, 0, 2, 7, 0, 4, null, null, 12, hasRedJellyDrop(), 0);
            case "goblin":
                return new Enemy("Mage Goo", 6, 0, 16, 3, 2, 7, 15, 4, null, null, 16, hasBlueJellyDrop(), 6);
            case "mage goo":
                return new Enemy("Goblin", 1, 0, 6, 0, 1, 4, 0, 1, null, null, 6, hasGoldPouchDrop(), 1);
            default:
                return null;
        }
    }

    private static Item hasRedJellyDrop() {
        // 1/8 chance of dropping Red Jelly
        if (random.nextInt(8) == 0) {
            return new Item("Red Jelly", "Restores 5 HP", 5);
        }
        return null;
    }

    private static Item hasBlueJellyDrop() {
        // 1/8 chance of dropping Blue Jelly
        if (random.nextInt(8) == 0) {
            return new Item("Blue Jelly", "Restores 5 AP", 5);
        }
        return null;
    }

    private static Item hasGoldPouchDrop() {
        // 1/20 chance of dropping Gold Pouch
        if (random.nextInt(20) == 0) {
            return new Item("Gold Pouch", "Adds 20 gold to inventory", 20);
        }
        return null;
    }

    private static void displayWorldActions() {
        if (!unlockedZebbugTown) {
            System.out.println("Choose an action:");
            System.out.println("1. Travel");
            System.out.println("2. Camp");
            System.out.println("0. Exit Game");
        } else {
            System.out.println("Choose an action:");
            System.out.println("1. Travel");
            System.out.println("2. Camp");
            System.out.println("3. Go To Zebbug Town");
            System.out.println("4. Exit");
        }
    }

    private static int selectRandomIndex(int[] probabilities) {
        int total = Arrays.stream(probabilities).sum();
        int randomNum = random.nextInt(total);
        int sum = 0;
        for (int i = 0; i < probabilities.length; i++) {
            sum += probabilities[i];
            if (randomNum < sum) {
                return i;
            }
        }
        return probabilities.length - 1;
    }

    private static void battleSystem(Character player, Enemy enemy) {
        System.out.println("Battle Start!");
    
        // Print initial player and enemy information
        System.out.println("Player: " + player.getName() + " | HP: " + player.getHP() + " | AP: " + player.getAP());
        System.out.println("Enemy: " + enemy.getName() + " | HP: " + enemy.getHP());
    
        do {
            displayBattleOptions();
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    attack(player, enemy);
                    break;
                case 2:
                    defend(player);
                    break;
                case 3:
                    useItem(player);
                    break;
                case 4:
                    useAbility(player);
                    break;
                case 5:
                    examine(player, enemy);
                    break;
                case 6:
                    flee(player, enemy);
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
    
            // Enemy's turn
            enemyAttack(player, enemy);
    
            // Print updated player and enemy information after each turn
            System.out.println("Player: " + player.getName() + " | HP: " + player.getHP() + " | AP: " + player.getAP());
            System.out.println("Enemy: " + enemy.getName() + " | HP: " + enemy.getHP());
    
        } while (player.isAlive() && enemy.isAlive());
    
        if (player.isAlive()) {
            System.out.println("You defeated the enemy!");
            // Handle experience and level up logic here
        } else {
            System.out.println("You were defeated. Reloading from the last save...");
            // Reload last save
            loadGame();
        }
    }
    

    private static void displayBattleOptions() {
        System.out.println("Choose an action:");
        System.out.println("1. Attack");
        System.out.println("2. Defend");
        System.out.println("3. Use Item");
        System.out.println("4. Abilities");
        System.out.println("5. Examine");
        System.out.println("6. Flee");
    }

    private static void attack(Character player, Enemy enemy) {
        // Implement attack logic based on player's stats
        int damage = player.getAttackDamage();
        enemy.takeDamage(damage);
        System.out.println("You dealt " + damage + " damage to the enemy!");
    }

    private static void defend(Character player) {
        // Implement defend logic based on player's stats
        int defense = player.getDef();
        System.out.println("You chose to defend. Increased defense by " + defense + ".");
    }

    private static void useItem(Character player) {
        // Implement logic to use items
        // For simplicity, you can assume the player has a healing item
        // Replace this with your actual item usage logic
        int healAmount = 10;
        player.heal(healAmount);
        System.out.println("You used a healing item. Restored " + healAmount + " HP.");
    }

    private static void useAbility(Character player) {
        // Implement logic to use abilities
        // Abilities may consume player's AP and deal damage based on Int stat
        // You can add more complexity to this based on your game design
        int abilityDamage = player.getInt();
        int apCost = 5; // Example AP cost
        if (player.getAP() >= apCost) {
            player.decreaseAP(apCost);
            System.out.println("You used an ability and dealt " + abilityDamage + " damage to the enemy!");
        } else {
            System.out.println("Not enough AP to use the ability.");
        }
    }

    private static void examine(Character player, Enemy enemy) {
        // Implement logic to examine the enemy
        // For simplicity, let's assume the player always learns a new ability
        Ability newAbility = new Ability("Fireball", 10, 5); // Example new ability with base damage 10 and AP cost 5
        player.addAbility(newAbility);
        System.out.println("You examined the enemy and learned a new ability: " + newAbility.getName() + "!");
    }

    private static void flee(Character player, Enemy enemy) {
        // Implement logic to flee from battle
        // Success depends on player's agility
        int fleeChance = player.getAgl() * 5; // Example: 5% per agility point
        if (random.nextInt(100) < fleeChance) {
            System.out.println("You successfully fled from the battle!");
            // Additional logic after successful flee
        } else {
            System.out.println("You failed to flee. The enemy attacks!");
            // Additional logic if flee fails
            enemyAttack(player, enemy);
        }
    }

    private static void enemyAttack(Character player, Enemy enemy) {
        // Implement logic for the enemy's attack
        int damage = enemy.getAttackDamage();
        player.takeDamage(damage);
        System.out.println("The enemy dealt " + damage + " damage to you!");
    }
}
