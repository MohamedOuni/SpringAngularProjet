package esprit.tn.projetspringbootangular.Entities;

import java.util.Arrays;

public enum TypeVote {
    UPVOTE(1), DOWNVOTE(-1),
    ;

    private int direction;

    TypeVote(int direction) {
    }

  /*  public static TypeVote lookup(Integer direction) {
        return Arrays.stream(TypeVote.values())
                .filter(value -> value.getDirection().equals(direction))
                .findAny()
                .orElseThrow(() -> new SpringForumException("Vote not found"));
    } */

    public Integer getDirection() {
        return direction;
    }
}
