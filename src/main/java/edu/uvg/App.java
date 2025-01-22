package edu.uvg;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);Blender blender=new Blender(2000);int option;

        do{System.out.println("\n--- Blender Menu ---");System.out.println("1. Check power status");System.out.println("2. Switch power status");System.out.println("3. Fill blender");System.out.println("4. Check current capacity");System.out.println("5. Increase speed");System.out.println("6. Decrease speed");System.out.println("7. Check speed");System.out.println("8. Check if blender is full");System.out.println("9. Empty blender");System.out.println("0. Exit");System.out.print("Select an option: ");option=scanner.nextInt();scanner.nextLine();

        switch(option){case 1->System.out.println("Power status: "+(blender.checkPowerStatus()==1?"On":"Off"));case 2->System.out.println("Power toggled to: "+(blender.switchPowerStatus()==1?"On":"Off"));case 3->{System.out.print("Enter product name: ");String prod=scanner.nextLine();System.out.print("Enter amount in ml: ");float ml=scanner.nextFloat();blender.fillBlender(prod,ml);}case 4->System.out.println("Current capacity: "+blender.actualCapacity()+" ml");case 5->blender.increaseSpeed();case 6->blender.decreaseSpeed();case 7->System.out.println("Current speed: "+blender.checkSpeed());case 8->System.out.println("Is blender full? "+(blender.isFull()?"Yes":"No"));case 9->blender.emptyBlender();case 0->System.out.println("Exiting program...");default->System.out.println("Invalid option. Try again.");}}while(option!=0);

        scanner.close();
    }

}
