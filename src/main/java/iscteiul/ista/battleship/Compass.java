/**
 * Representa as orientações possíveis de um navio no tabuleiro do jogo da Batalha Naval.
 * <p>
 * Cada orientação está associada a um carácter, que é usado na leitura
 * dos dados introduzidos pelo utilizador e na apresentação dos navios:
 * </p>
 * <ul>
 *   <li>NORTH: 'n' (norte);</li>
 *   <li>SOUTH: 's' (sul);</li>
 *   <li>EAST: 'e' (este);</li>
 *   <li>WEST: 'o' (oeste);</li>
 *   <li>UNKNOWN: 'u' (orientação desconhecida ou inválida).</li>
 * </ul>
 *
 * @author goncalo silva 123275
 * @see Ship
 */
package iscteiul.ista.battleship;

public enum Compass {
    /** Orientação a norte, representada pelo carácter 'n'. */
    NORTH('n'),
    /** Orientação a sul, representada pelo carácter 's'. */
    SOUTH('s'),
    /** Orientação a este, representada pelo carácter 'e'. */
    EAST('e'),
    /** Orientação a oeste, representada pelo carácter 'o'. */
    WEST('o'),
    /** Orientação desconhecida, usada quando o carácter lido não é válido. */
    UNKNOWN('u');

    /** Carácter que identifica a orientação. */
    private final char c;

    /**
     * Constrói uma orientação associada ao carácter indicado.
     *
     * @param c carácter que representa a orientação
     */
    Compass(char c) {
        this.c = c;
    }

    /**
     * Devolve o carácter que representa esta orientação.
     *
     * @return o carácter associado à orientação ('n', 's', 'e', 'o' ou 'u')
     */
    public char getDirection() {
        return c;
    }

    /**
     * Devolve a representação textual desta orientação.
     *
     * @return uma String com o carácter associado à orientação
     */
    @Override
    public String toString() {
        return "" + c;
    }

    /**
     * Converte um carácter na orientação correspondente.
     * <p>
     * Os caracteres reconhecidos são 'n', 's', 'e' e 'o'. Qualquer outro
     * carácter é convertido em {@link #UNKNOWN}.
     * </p>
     *
     * @param ch carácter que representa a orientação
     * @return a orientação correspondente ao carácter, ou {@link #UNKNOWN}
     *         se o carácter não for válido
     */
    static Compass charToCompass(char ch) {
        Compass bearing;
        switch (ch) {
            case 'n':
                bearing = NORTH;
                break;
            case 's':
                bearing = SOUTH;
                break;
            case 'e':
                bearing = EAST;
                break;
            case 'o':
                bearing = WEST;
                break;
            default:
                bearing = UNKNOWN;
        }

        return bearing;
    }
}
