/**
 * Representa uma fragata no jogo da Batalha Naval.
 * <p>
 * A fragata ocupa 4 posições consecutivas no tabuleiro, dispostas na vertical
 * NORTH ou SOUTH ou na horizontal
 * EAST ou WEST a partir da posição inicial indicada.
 * </p>
 *
 * @see Ship
 * @see Compass
 * @see IPosition
 */
package iscteiul.ista.battleship;

public class Frigate extends Ship {
    /** Número de posições ocupadas por uma fragata. */
    private static final Integer SIZE = 4;
    /** Nome da embarcação, usado na identificação do tipo de navio. */
    private static final String NAME = "Fragata";
    
    /**
     * Constrói uma fragata com a orientação e a posição inicial indicadas.
     * <p>
     * As posições ocupadas são calculadas a partir de pos:
     * </p>
     * <ul>
     *   <li>NORTH ou SOUTH: a fragata estende-se para baixo,
     *       incrementando a linha em cada posição;</li>
     *   <li>East ou WEST: a fragata estende-se para a direita,
     *       incrementando a coluna em cada posição.</li>
     * </ul>
     *
     * @param bearing orientação da fragata no tabuleiro; não pode ser null
     * @param pos     posição inicial (primeira célula) da fragata
     * @throws IllegalArgumentException se a orientação bearing não for válida
     *                                  para uma fragata
     * @throws NullPointerException     se bearing for null
     */
    public Frigate(Compass bearing, IPosition pos) throws IllegalArgumentException {
        super(Frigate.NAME, bearing, pos);
        switch (bearing) {
            case NORTH:
            case SOUTH:
                for (int r = 0; r < SIZE; r++)
                    getPositions().add(new Position(pos.getRow() + r, pos.getColumn()));
                break;
            case EAST:
            case WEST:
                for (int c = 0; c < SIZE; c++)
                    getPositions().add(new Position(pos.getRow(), pos.getColumn() + c));
                break;
            default:
                throw new IllegalArgumentException("ERROR! invalid bearing for thr frigate");
        }
    }

   /**
     * Devolve o tamanho da fragata.
     *
     * @return o número de posições ocupadas pela fragata (sempre 4)
     */
    @Override
    public Integer getSize() {
        return Frigate.SIZE;
    }

}
