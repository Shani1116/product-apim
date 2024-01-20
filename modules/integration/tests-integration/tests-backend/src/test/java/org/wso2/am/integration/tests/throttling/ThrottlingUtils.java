/*
 * Copyright (c) 2024, WSO2 LLC. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.am.integration.tests.throttling;

import java.util.Calendar;

/*
 *Copyright (c) 2024, WSO2 LLC. (http://www.wso2.org) All Rights Reserved.
 *
 *WSO2 Inc. licenses this file to you under the Apache License,
 *Version 2.0 (the "License"); you may not use this file except
 *in compliance with the License.
 *You may obtain a copy of the License at
 *
 *http://www.apache.org/licenses/LICENSE-2.0
 *
 *Unless required by applicable law or agreed to in writing,
 *software distributed under the License is distributed on an
 *"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *KIND, either express or implied.  See the License for the
 *specific language governing permissions and limitations
 *under the License.
 */
public class ThrottlingUtils {
    public static int WAIT_FOR_JMS_THROTTLE_EVENT_IN_MILLISECONDS = 3000;

    /**
     * Wait until next hour starts if the current hour has only n minutes left.
     * @param n
     * @throws InterruptedException
     */
    public static void waitUntilNextClockHourIfCurrentHourIsInLastNMinutes(int n) throws InterruptedException {
        int timeUntilNextHour = getTimeToNextHourInMinutes();
        if (n >= timeUntilNextHour) {
            Thread.sleep(timeUntilNextHour * 60 * 1000);
        }
    }

    public static int getTimeToNextHourInMinutes() {
        Calendar calendar = Calendar.getInstance();
        int minutesInTime = calendar.get(Calendar.MINUTE);
        return 60 - minutesInTime;
    }
}