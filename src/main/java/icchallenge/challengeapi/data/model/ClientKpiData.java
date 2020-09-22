package icchallenge.challengeapi.data.model;

import lombok.Builder;
import lombok.Data;

/**
 * Model class in charge of hold {@link Client} calculated data.
 *
 * @author Marco Marchetti
 */
@Data
@Builder
public class ClientKpiData {

    private double ageAverage;
    private double ageStandardDeviation;
}
