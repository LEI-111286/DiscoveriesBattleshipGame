package iscteiul.ista.battleship;

import java.util.ArrayList;
import java.util.List;

/**
 * Implements a fleet of ships of the Battleship game.
 *
 * <p>A fleet stores the ships placed on the board, enforces the board rules
 * (ships must fit inside the board and cannot collide with each other) and
 * provides operations to inspect its ships, such as listing the ships of a
 * category or the ships that are still floating.</p>
 */
public class Fleet implements IFleet {
    /**
     * Prints all the given ships, one per line.
     *
     * @param ships the list of ships to print
     */
    static void printShips(List<IShip> ships) {
        for (IShip ship : ships)
            System.out.println(ship);
    }

    // -----------------------------------------------------

    private List<IShip> ships;

    /**
     * Creates an empty fleet.
     */
    public Fleet() {
        ships = new ArrayList<>();
    }

    /**
     * Returns the list of ships that belong to this fleet.
     *
     * @return the list of ships of the fleet
     */
    @Override
    public List<IShip> getShips() {
        return ships;
    }

    /**
     * Adds a ship to the fleet, if the fleet is not full and the ship is
     * placed inside the board without risking a collision.
     *
     * @param s the ship to add
     * @return true if the ship was added, false otherwise
     */
    @Override
    public boolean addShip(IShip s) {
        boolean result = false;
        if ((ships.size() <= FLEET_SIZE) && (isInsideBoard(s)) && (!colisionRisk(s))) {
            ships.add(s);
            result = true;
        }
        return result;
    }

    /**
     * Returns the ships of the fleet that belong to the given category.
     *
     * @param category the category of ships of interest
     * @return the list of ships of that category
     */
    @Override
    public List<IShip> getShipsLike(String category) {
        List<IShip> shipsLike = new ArrayList<>();
        for (IShip s : ships)
            if (s.getCategory().equals(category))
                shipsLike.add(s);

        return shipsLike;
    }

    /**
     * Returns the ships of the fleet that are still floating.
     *
     * @return the list of ships that have not been sank yet
     */
    @Override
    public List<IShip> getFloatingShips() {
        List<IShip> floatingShips = new ArrayList<>();
        for (IShip s : ships)
            if (s.stillFloating())
                floatingShips.add(s);

        return floatingShips;
    }

    /**
     * Returns the ship that occupies the given position, if any.
     *
     * @param pos the position to look up
     * @return the ship occupying the position, or null if no ship is there
     */
    @Override
    public IShip shipAt(IPosition pos) {
        for (int i = 0; i < ships.size(); i++)
            if (ships.get(i).occupies(pos))
                return ships.get(i);
        return null;
    }

    /**
     * Checks whether the whole ship fits inside the board.
     *
     * @param s the ship to check
     * @return true if every position of the ship is inside the board
     */
    private boolean isInsideBoard(IShip s) {
        return (s.getLeftMostPos() >= 0 && s.getRightMostPos() <= BOARD_SIZE - 1 && s.getTopMostPos() >= 0
                && s.getBottomMostPos() <= BOARD_SIZE - 1);
    }

    /**
     * Checks whether the given ship is too close to any ship of the fleet.
     *
     * @param s the ship to check
     * @return true if the ship risks colliding with another ship
     */
    private boolean colisionRisk(IShip s) {
        for (int i = 0; i < ships.size(); i++) {
            if (ships.get(i).tooCloseTo(s))
                return true;
        }
        return false;
    }


    /**
     * Prints the current state of the fleet: all ships, the floating ships
     * and the ships of every category.
     */
    public void printStatus() {
        printAllShips();
        printFloatingShips();
        printShipsByCategory("Galeao");
        printShipsByCategory("Fragata");
        printShipsByCategory("Nau");
        printShipsByCategory("Caravela");
        printShipsByCategory("Barca");
    }

    /**
     * Prints all the ships of the fleet belonging to a particular category.
     *
     * @param category the category of ships of interest
     */
    public void printShipsByCategory(String category) {
        assert category != null;

        printShips(getShipsLike(category));
    }

    /**
     * Prints all the ships of the fleet that have not been sank yet.
     */
    public void printFloatingShips() {
        printShips(getFloatingShips());
    }

    /**
     * Prints all the ships of the fleet, one per line.
     */
    void printAllShips() {
        printShips(ships);
    }

}