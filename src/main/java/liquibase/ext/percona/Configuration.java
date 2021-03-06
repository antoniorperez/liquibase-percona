package liquibase.ext.percona;

/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * Encapsulates runtime configuration for percona.
 */
public final class Configuration {
    /** Fail liquibase update if no percona toolkit is found. */
    public static final String FAIL_IF_NO_PT = "liquibase.percona.failIfNoPT";
    /** Do not generate the alter table statements in dry mode (updateSQL / rollbackSQL) */
    public static final String NO_ALTER_SQL_DRY_MODE = "liquibase.percona.noAlterSqlDryMode";
    /** Do not use percona for the given changes, separated by comma. */
    public static final String SKIP_CHANGES = "liquibase.percona.skipChanges";
    /** Additional command line options that are passed to pt-online-schema-change. */
    public static final String ADDITIONAL_OPTIONS = "liquibase.percona.options";
    /** Default value for the "usePercona" flag for each change. */
    public static final String DEFAULT_ON = "liquibase.percona.defaultOn";

    public static boolean failIfNoPT() {
        return Boolean.getBoolean(FAIL_IF_NO_PT);
    }

    public static boolean noAlterSqlDryMode() {
        return Boolean.getBoolean(NO_ALTER_SQL_DRY_MODE);
    }

    public static boolean skipChange(String change) {
        return System.getProperty(SKIP_CHANGES, "").contains(change);
    }

    public static String getAdditionalOptions() {
        return System.getProperty(ADDITIONAL_OPTIONS, "");
    }

    public static boolean getDefaultOn() {
        return Boolean.parseBoolean(System.getProperty(DEFAULT_ON, "true"));
    }
}
