package com.liferay.blade.upgrade.liferay70.apichanges;

import java.io.File;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import com.liferay.blade.api.FileMigrator;
import com.liferay.blade.api.JavaFile;
import com.liferay.blade.api.SearchResult;
import com.liferay.blade.upgrade.liferay70.JavaFileMigrator;

@Component(
	property = {
		"file.extensions=java,jsp,jspf",
		"problem.summary=All Social Networking APIs previously exposed as Liferay Portal API in 6.2 have been move out from portal-service into separate OSGi modules",
		"problem.tickets=LPS-50752",
		"problem.title=Social Networking APIs migrated to OSGi module",
		"problem.section=#legacy"
	},
	service = FileMigrator.class
)
public class SocialNetworkingLegacyAPI extends JavaFileMigrator {

	private static final String[] SERVICE_API_PREFIXES =  {
		"com.liferay.socialnetworking.service.MeetupsEntry",
		"com.liferay.socialnetworking.service.MeetupsRegistration",
		"com.liferay.socialnetworking.service.WallEntry",

	};

	@Override
	protected List<SearchResult> searchFile(File file, JavaFile javaFileChecker) {
		return javaFileChecker.findServiceAPIs(SERVICE_API_PREFIXES);
	}
}
