package iscteiul.ista.battleship;

/**
 * Representa a embarcação do tipo Galeão (Galleon) no jogo da Batalha Naval dos Descobrimentos.
 * O Galeão tem dimensão 5 (tamanho máximo) e ocupa posições na grelha de acordo com a sua orientação.
 *
 * @author Tomás Leal (LEI-111491)
 */
public class Galleon extends Ship {

    /**
     * Dimensão fixa do Galeão em número de células na grelha.
     */
    private static final Integer SIZE = 5;

    /**
     * Nome identificador do tipo de navio.
     */
    private static final String NAME = "Galeao";

    /**
     * Construtor da classe Galleon.
     * Cria e posiciona o Galeão no tabuleiro a partir de uma posição de referência e orientação indicada.
     *
     * @param bearing A orientação geográfica do navio (NORTH, EAST, SOUTH ou WEST).
     * @param pos A posição de referência inicial na grelha onde o navio é colocado.
     * @throws NullPointerException Se a orientação fornecida for nula.
     * @throws IllegalArgumentException Se a orientação for inválida para a criação do navio.
     */
    public Galleon(Compass bearing, IPosition pos) throws IllegalArgumentException {
        super(Galleon.NAME, bearing, pos);

        if (bearing == null)
            throw new NullPointerException("ERROR! invalid bearing for the galleon");

        switch (bearing) {
            case NORTH:
                fillNorth(pos);
                break;
            case EAST:
                fillEast(pos);
                break;
            case SOUTH:
                fillSouth(pos);
                break;
            case WEST:
                fillWest(pos);
                break;

            default:
                throw new IllegalArgumentException("ERROR! invalid bearing for the galleon");
        }
    }

    /**
     * Devolve o tamanho total da embarcação em células ocupadas.
     *
     * @return O número de posições ocupadas pelo Galeão (sempre 5).
     */
    @Override
    public Integer getSize() {
        return Galleon.SIZE;
    }

    /**
     * Preenche a lista de posições do Galeão com orientação virada a Norte.
     *
     * @param pos A posição de referência base.
     */
    private void fillNorth(IPosition pos) {
        for (int i = 0; i < 3; i++) {
            getPositions().add(new Position(pos.getRow(), pos.getColumn() + i));
        }
        getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + 1));
        getPositions().add(new Position(pos.getRow() + 2, pos.getColumn() + 1));
    }

    /**
     * Preenche a lista de posições do Galeão com orientação virada a Sul.
     *
     * @param pos A posição de referência base.
     */
    private void fillSouth(IPosition pos) {
        for (int i = 0; i < 2; i++) {
            getPositions().add(new Position(pos.getRow() + i, pos.getColumn()));
        }
        for (int j = 2; j < 5; j++) {
            getPositions().add(new Position(pos.getRow() + 2, pos.getColumn() + j - 3));
        }
    }

    /**
     * Preenche a lista de posições do Galeão com orientação virada a Este.
     *
     * @param pos A posição de referência base.
     */
    private void fillEast(IPosition pos) {
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
        for (int i = 1; i < 4; i++) {
            getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + i - 3));
        }
        getPositions().add(new Position(pos.getRow() + 2, pos.getColumn()));
    }

    /**
     * Preenche a lista de posições do Galeão com orientação virada a Oeste.
     *
     * @param pos A posição de referência base.
     */
    private void fillWest(IPosition pos) {
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
        for (int i = 1; i < 4; i++) {
            getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + i - 1));
        }
        getPositions().add(new Position(pos.getRow() + 2, pos.getColumn()));
    }
}
